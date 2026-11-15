package com.ronit.loveable_clone.repository;

import com.ronit.loveable_clone.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProjectRepository extends JpaRepository<Project, UUID> {

    @Query(
            """
                SELECT p FROM Project p
                WHERE p.deletedAt IS NULL
                AND p.owner.id = :userId
                ORDER BY p.updatedAt DESC
            """
    )
    List<Project> findAllAccessibleProjectByUser(@Param("userId") UUID userId);

    @Query(
            """
                SELECT p FROM Project p
                LEFT JOIN FETCH p.owner
                WHERE p.id = :projectId
                    AND p.deletedAt IS NULL
                    AND p.owner.id = :userId
            """
    )
    Optional<Project> findAllAccessibleProjectById(@Param("projectId") UUID projectId, @Param("userId") UUID userId);

}
