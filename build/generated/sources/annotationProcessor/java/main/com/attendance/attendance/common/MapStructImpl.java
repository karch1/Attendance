package com.attendance.attendance.common;

import com.attendance.attendance.dept.dto.DepartmentDto;
import com.attendance.attendance.dept.entity.Department;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-19T15:23:28+0900",
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

        departmentDto.setDept_Id( department.getDept_Id() );
        departmentDto.setDept_Name( department.getDept_Name() );
        departmentDto.setLocation( department.getLocation() );

        return departmentDto;
    }

    @Override
    public Department toEntity(DepartmentDto departmentDto) {
        if ( departmentDto == null ) {
            return null;
        }

        Department department = new Department();

        department.setDept_Id( departmentDto.getDept_Id() );
        department.setDept_Name( departmentDto.getDept_Name() );
        department.setLocation( departmentDto.getLocation() );

        return department;
    }

    @Override
    public void updateFromDto(DepartmentDto departmentDto, Department department) {
        if ( departmentDto == null ) {
            return;
        }

        if ( departmentDto.getDept_Id() != null ) {
            department.setDept_Id( departmentDto.getDept_Id() );
        }
        if ( departmentDto.getDept_Name() != null ) {
            department.setDept_Name( departmentDto.getDept_Name() );
        }
        if ( departmentDto.getLocation() != null ) {
            department.setLocation( departmentDto.getLocation() );
        }
    }
}
