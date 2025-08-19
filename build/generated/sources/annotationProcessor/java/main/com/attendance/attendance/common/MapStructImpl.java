package com.attendance.attendance.common;

import com.attendance.attendance.department.dto.DepartmentDto;
import com.attendance.attendance.department.entity.Department;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-19T18:44:48+0900",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.3.jar, environment: Java 17.0.16 (Azul Systems, Inc.)"
)
@Component
public class MapStructImpl implements MapStruct {

    @Override
    public DepartmentDto toDto(Department department) {
        if ( department == null ) {
            return null;
        }

        DepartmentDto departmentDto = new DepartmentDto();

        departmentDto.setDeptId( department.getDeptId() );
        departmentDto.setDeptName( department.getDeptName() );
        departmentDto.setLocation( department.getLocation() );

        return departmentDto;
    }

    @Override
    public Department toEntity(DepartmentDto departmentDto) {
        if ( departmentDto == null ) {
            return null;
        }

        Department department = new Department();

        department.setDeptId( departmentDto.getDeptId() );
        department.setDeptName( departmentDto.getDeptName() );
        department.setLocation( departmentDto.getLocation() );

        return department;
    }

    @Override
    public void updateFromDto(DepartmentDto departmentDto, Department department) {
        if ( departmentDto == null ) {
            return;
        }

        if ( departmentDto.getDeptId() != null ) {
            department.setDeptId( departmentDto.getDeptId() );
        }
        if ( departmentDto.getDeptName() != null ) {
            department.setDeptName( departmentDto.getDeptName() );
        }
        if ( departmentDto.getLocation() != null ) {
            department.setLocation( departmentDto.getLocation() );
        }
    }
}
