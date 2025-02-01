package com.mycompany.courseerpbackend.repository;

import com.mycompany.courseerpbackend.models.mybatis.branch.Branch;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BranchRepository {

    void insert(Branch branch);

}
