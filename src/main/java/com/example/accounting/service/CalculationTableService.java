package com.example.accounting.service;

import com.example.accounting.dto.EmployeeRequestDto;
import com.example.accounting.entity.CalculationTable;
import com.example.accounting.entity.Employee;
import com.example.accounting.exception.DataNotFoundException;
//import com.example.accounting.exeption.DataNotFoundException;
import com.example.accounting.exception.UniqueObjectException;
import com.example.accounting.repository.CalculationTableRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CalculationTableService {
    private final ModelMapper modelMapper;
    private final CalculationTableRepository calculationTableRepository;
    public CalculationTable save(CalculationTable calculationTable) {
        if (calculationTableRepository.findEmployeesByEmployee(calculationTable.getEmployee()) != null) {
            return calculationTableRepository.save(calculationTable);
        }
        throw new UniqueObjectException("CalcutaionTable already exists");
    }

    public void delete (UUID calculationTableid ){
         CalculationTable calculationTable = calculationTableRepository.findById(calculationTableid).orElseThrow(
                ()->new DataNotFoundException("calculationTable not found by id ")
        );
        calculationTableRepository.delete(calculationTable);
    }
    public CalculationTable getByID(UUID calculationTableId) {
        return calculationTableRepository.findById(calculationTableId).orElseThrow(
                () -> new DataNotFoundException("CalculationTable not found"));
    }
    public CalculationTable update(CalculationTable update, UUID id) {
        // TODO this method dont work as expected, correct it
        CalculationTable calculation = calculationTableRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("calculation not found"));
        modelMapper.map(update, calculation);
        return calculationTableRepository.save(calculation);
    }
}
