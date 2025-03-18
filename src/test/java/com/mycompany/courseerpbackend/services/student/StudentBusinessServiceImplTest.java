package com.mycompany.courseerpbackend.services.student;

import com.mycompany.courseerpbackend.exception.BaseException;
import com.mycompany.courseerpbackend.models.mybatis.role.Role;
import com.mycompany.courseerpbackend.models.mybatis.student.Student;
import com.mycompany.courseerpbackend.models.mybatis.user.User;
import com.mycompany.courseerpbackend.models.payload.student.StudentPayload;
import com.mycompany.courseerpbackend.services.group.GroupService;
import com.mycompany.courseerpbackend.services.role.RoleService;
import com.mycompany.courseerpbackend.services.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentBusinessServiceImplTest {

    @Mock
    private StudentService studentService;

    @Mock
    private UserService userService;

    @Mock
    private RoleService roleService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private GroupService groupService;

    @InjectMocks
    private StudentBusinessServiceImpl studentBusinessService;

    private StudentPayload studentPayload;
    private User user;
    private Role role;

    @BeforeEach
    void setUp() {
        studentPayload = new StudentPayload("John", "Doe", "john@example.com", "+123456789");
        role = new Role();
        role.setId(1L);
        user = new User();
        user.setId(1L);
    }

    @Test
    void addStudentWhenPhoneNumberExists() {
        when(userService.checkByPhoneNumber(studentPayload.getPhoneNumber())).thenReturn(true);

        assertThrows(BaseException.class, () -> studentBusinessService.addStudent(studentPayload));

        verify(userService, times(1)).checkByPhoneNumber(studentPayload.getPhoneNumber());
        verifyNoMoreInteractions(userService, roleService, passwordEncoder, studentService);
    }

    @Test
    void addStudentWhenSucceeds() {
        when(userService.checkByPhoneNumber(studentPayload.getPhoneNumber())).thenReturn(false);
        when(roleService.getDefaultRole()).thenReturn(role);
        when(passwordEncoder.encode(any())).thenReturn("encryptedPassword");
        doAnswer(invocation -> {
            User insertedUser = invocation.getArgument(0);
            insertedUser.setId(1L);
            return null;
        }).when(userService).insert(any(User.class));

        studentBusinessService.addStudent(studentPayload);

        verify(userService, times(1)).insert(any(User.class));
        verify(studentService, times(1)).insert(any(Student.class));
    }

    @Test
    void addStudentToGroupWhenStudentOrGroupNotFound() {
        Long studentId = 1L;
        Long groupId = 2L;

        doThrow(new RuntimeException("Student not found")).when(studentService).findById(studentId);

        assertThrows(RuntimeException.class, () -> studentBusinessService.addStudentToGroup(studentId, groupId));

        verify(studentService, times(1)).findById(studentId);
        verifyNoInteractions(groupService);
    }

    @Test
    void addStudentToGroupWhenStudentAlreadyAdded() {
        Long studentId = 1L;
        Long groupId = 2L;

        when(studentService.findById(studentId)).thenReturn(new Student());
        when(groupService.findById(groupId)).thenReturn(null);
        when(studentService.checkStudentAlreadyAddedToGroup(studentId, groupId)).thenReturn(true);

        assertThrows(BaseException.class, () -> studentBusinessService.addStudentToGroup(studentId, groupId));

        verify(studentService, times(1)).checkStudentAlreadyAddedToGroup(studentId, groupId);
    }

    @Test
    void addStudentToGroupWhenSucceeds() {
        Long studentId = 1L;
        Long groupId = 2L;

        when(studentService.findById(studentId)).thenReturn(new Student());
        when(groupService.findById(groupId)).thenReturn(null);
        when(studentService.checkStudentAlreadyAddedToGroup(studentId, groupId)).thenReturn(false);

        studentBusinessService.addStudentToGroup(studentId, groupId);

        verify(studentService, times(1)).addStudentToGroup(studentId, groupId);
    }
}
