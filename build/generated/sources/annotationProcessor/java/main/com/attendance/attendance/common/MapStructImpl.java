package com.attendance.attendance.common;

import com.attendance.attendance.department.dto.DeptDto;
import com.attendance.attendance.department.entity.Department;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-19T15:16:26+0900",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.3.jar, environment: Java 17.0.16 (Azul Systems, Inc.)"
)
@Component
public class MapStructImpl implements MapStruct {

    @Override
    public DeptDto toDto(Department department) {
        if ( department == null ) {
            return null;
        }

        DeptDto deptDto = new DeptDto();

        deptDto.setDeptId( department.getDeptId() );
        deptDto.setDeptName( department.getDeptName() );
        deptDto.setLocation( department.getLocation() );

        return deptDto;
    }

    @Override
    public Department toEntity(DeptDto deptDto) {
        if ( deptDto == null ) {
            return null;
        }

        Department department = new Department();

        department.setDeptId( deptDto.getDeptId() );
        department.setDeptName( deptDto.getDeptName() );
        department.setLocation( deptDto.getLocation() );

        return department;
    }

    @Override
    public void updateFromDto(DeptDto deptDto, Department department) {
        if ( deptDto == null ) {
            return;
        }

        if ( deptDto.getDeptId() != null ) {
            department.setDeptId( deptDto.getDeptId() );
        }
        if ( deptDto.getDeptName() != null ) {
            department.setDeptName( deptDto.getDeptName() );
        }
        if ( deptDto.getLocation() != null ) {
            department.setLocation( deptDto.getLocation() );
        }
    }
}
