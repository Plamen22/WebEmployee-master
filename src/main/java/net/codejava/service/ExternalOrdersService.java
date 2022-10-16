package net.codejava.service;

import net.codejava.models.ExternalOrders;
import net.codejava.repository.ExternalOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ExternalOrdersService {
    @Autowired
    private ExternalOrdersRepository externalOrdersRepository;

    public Iterable<ExternalOrders> findAll() {
        return externalOrdersRepository.findAll();
    }

    public boolean existsById(long id) {
        return externalOrdersRepository.existsById(id);
    }

    public Optional<ExternalOrders> findById(long id) {
        return externalOrdersRepository.findById(id);
    }

    public ExternalOrders save(ExternalOrders workerSchedule) {
        return externalOrdersRepository.save(workerSchedule);
    }

    public void deleteById(long id) {
        externalOrdersRepository.deleteById(id);
    }
}

