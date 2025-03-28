package br.com.barber.api.service.query;

import java.time.OffsetDateTime;
import java.util.List;

import br.com.barber.api.entity.ScheduleEntity;

public interface IScheduleQueryService {

    ScheduleEntity findById(final long id);

    List<ScheduleEntity> findInMonth(final OffsetDateTime startAt, final OffsetDateTime endAt);

    void verifyIfScheduleExists(final OffsetDateTime startAt, final OffsetDateTime endAt);

}

