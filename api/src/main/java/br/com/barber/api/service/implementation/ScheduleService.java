package br.com.barber.api.service.implementation;

import org.springframework.stereotype.Repository;

import br.com.barber.api.entity.ScheduleEntity;
import br.com.barber.api.repository.IScheduleRepository;
import br.com.barber.api.service.IScheduleService;
import br.com.barber.api.service.query.IScheduleQueryService;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class ScheduleService implements IScheduleService {

    private final IScheduleRepository repository;
    private final IScheduleQueryService queryService;

    @Override
    public ScheduleEntity save(final ScheduleEntity entity) {
        queryService.verifyIfScheduleExists(entity.getStartAt(), entity.getEndAt());

        return repository.save(entity);
    }

    @Override
    public void delete(final long id) {
        queryService.findById(id);
        repository.deleteById(id);
    }
}
