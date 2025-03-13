package lk.ijse.backend.repo;

import lk.ijse.backend.entity.Services;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Services, String> {
    boolean existsServiceByServiceName(String serviceName);
    Services findServiceByServiceName(String serviceName);
}
