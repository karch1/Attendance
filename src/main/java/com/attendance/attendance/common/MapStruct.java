package com.attendance.attendance.common;

import com.attendance.attendance.dept.dto.DepartmentDto;
import com.attendance.attendance.dept.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE  // null 제외 기능(update 시 사용)
)
public interface MapStruct {

    // TODO: 1) Dept <-> DeptDto
    DepartmentDto toDto(Department department);
    Department toEntity(DepartmentDto departmentDto);
    // TODO: 수정 시 사용: dirty checking 기능(save() 없이 수정 가능)
    void updateFromDto(DepartmentDto departmentDto, @MappingTarget Department department);

//    // TODO: 2) Emp <-> EmpDto
//    @Mapping(source = "dept.dno", target = "dno")
//    EmpDto toDto(Emp emp);
//    @Mapping(source = "dno", target = "dept.dno")
//    Emp toEntity(EmpDto empDto);
//    // TODO: 수정 시 사용: dirty checking 기능(save() 없이 수정 가능)
////      경고 무시하고 싶으면 아래 추가하세요
//    void updateFromDto(EmpDto empDto, @MappingTarget Emp emp);
//
//    // TODO: 3) Dept <-> DeptDto
//    FaqDto toDto(Faq faq);
//    Faq toEntity(FaqDto faqDto);
//    // TODO: 수정 시 사용: dirty checking 기능(save() 없이 수정 가능)
//    void updateFromDto(FaqDto faqDto, @MappingTarget Faq faq);
//
//    //    TODO: 4) fileDb <-> fileDto
//    FileDbDto toDto(FileDb fileDb);
//    @Mapping(target = "fileData", ignore = true)
//    FileDb toEntity(FileDbDto fileDbDto);
//
//    //    TODO: 5) gallery <-> galleryDto
//    GalleryDto toDto(Gallery gallery);
//    @Mapping(target = "galleryData", ignore = true)
//    Gallery toEntity(GalleryDto galleryDto);
//
////    TODO: 6) member2 <-> member2Dto
//    Member2Dto toDto(Member2 member2);
//    Member2 toEntity(Member2Dto member2Dto);
}
