package lk.ijse.backend.service.impl;

import lk.ijse.backend.DTO.ServiceDTO;
import lk.ijse.backend.entity.Services;
import lk.ijse.backend.repo.ServiceRepository;
import lk.ijse.backend.service.ServiceService;
import lk.ijse.backend.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public int saveService(ServiceDTO serviceDTO) {
        if (serviceRepository.existsById(serviceDTO.getServiceId())) {
            return VarList.Not_Acceptable;
        } else {
            serviceRepository.save(modelMapper.map(serviceDTO, Services.class));
            return VarList.Created;
        }
    }

    @Override
    public ServiceDTO searchService(String serviceName) {
     /*   if (serviceRepository.existsById(serviceName)) {
            Services services = serviceRepository.findById(serviceName).get();
            return modelMapper.map(services, ServiceDTO.class);
        } else {
            return null;
        }*/
        return null;
    }

    @Override
    public int deleteService(long serviceId) {
        if (serviceRepository.existsById(serviceId)) {
            serviceRepository.deleteById(serviceId);
            return VarList.OK;
        } else {
            return VarList.Not_Found;
        }
    }

    @Override
    public int updateService(ServiceDTO serviceDTO) {
        if (serviceRepository.existsById(serviceDTO.getServiceId())) {
            serviceRepository.save(modelMapper.map(serviceDTO, Services.class));
            return VarList.OK;
        } else {
            return VarList.Not_Found;
        }
    }
}
