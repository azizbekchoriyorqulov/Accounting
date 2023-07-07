package com.example.accounting.service;

import com.example.accounting.entity.Employee;
import com.example.accounting.entity.Region;
import com.example.accounting.exception.DataNotFoundException;
import com.example.accounting.exception.UniqueObjectException;
import com.example.accounting.repository.OrganizationRepository;
import com.example.accounting.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegionService {
    private final RegionRepository repository;
    private final ModelMapper modelMapper;
    public Region save(Region region){
if(repository.findByName(region.getName()) != null){
   return repository.save(region);
}
        throw new UniqueObjectException(" already exists");
    }
    public void delete(String regionName ){
        Region region = repository.findByName(regionName);
        repository.delete(region);

    }
    public Region update(Region update,UUID id){
        Region region = repository.findById(id).orElseThrow(
                ()->new DataNotFoundException("region not found")
        );
        if (!update.name.isEmpty()){
            region.setName(update.getName());
        }
        return region;
    }
}
