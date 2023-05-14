package org.stc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.stc.domain.Permission;
import org.stc.domain.PermissionGroup;
import org.stc.domain.enumerations.PermissionLevel;

import java.util.List;
import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    Optional<Permission> findPermissionByUserEmailAndPermissionLevel(String mail, PermissionLevel permissionLevel);
    List<Permission> findAllByPermissionGroup(PermissionGroup permissionGroup);
}
