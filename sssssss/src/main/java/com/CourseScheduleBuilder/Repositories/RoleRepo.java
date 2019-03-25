package com.CourseScheduleBuilder.Repositories;

import com.CourseScheduleBuilder.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
}
