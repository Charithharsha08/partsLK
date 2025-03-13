package lk.ijse.backend.service;

import lk.ijse.backend.DTO.ServiceDTO;

public interface ServiceService {
    int saveService(ServiceDTO serviceDTO);
    ServiceDTO searchService(String serviceName);
    int deleteService(String serviceId);
    int updateService(ServiceDTO serviceDTO);
}
