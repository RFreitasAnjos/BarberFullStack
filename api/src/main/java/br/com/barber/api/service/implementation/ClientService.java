package br.com.barber.api.service.implementation;

import org.springframework.stereotype.Repository;

import br.com.barber.api.entity.ClientEntity;
import br.com.barber.api.repository.IClientRepository;
import br.com.barber.api.service.IClientService;
import br.com.barber.api.service.query.IClientQueryService;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class ClientService implements IClientService {

    private final IClientRepository repository;
    private final IClientQueryService queryService;

    @Override
    public ClientEntity save(final ClientEntity entity) {
        queryService.verifyEmail(entity.getEmail());
        queryService.verifyPhone(entity.getPhone());

        return repository.save(entity);
    }

    @Override
    public ClientEntity update(final ClientEntity entity) {
        queryService.verifyEmail(entity.getId(), entity.getEmail());
        queryService.verifyPhone(entity.getId(), entity.getPhone());

        var stored = queryService.findById(entity.getId());
        stored.setName(entity.getName());
        stored.setPhone(entity.getPhone());
        stored.setEmail(entity.getEmail());
        return repository.save(stored);
    }

    @Override
    public void delete(final Long id) {  // Change parameter type from long to Long
        queryService.findById(id);  // Ensure you're passing Long to the queryService
        repository.deleteById(id);  // Use Long in delete method
    }
}
