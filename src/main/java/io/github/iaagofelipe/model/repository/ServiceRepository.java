package io.github.iaagofelipe.model.repository;

import io.github.iaagofelipe.model.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
}
