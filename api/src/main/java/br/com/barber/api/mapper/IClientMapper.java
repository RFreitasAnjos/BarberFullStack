package br.com.barber.api.mapper;

import br.com.barber.api.controller.request.SaveClientRequest;
import br.com.barber.api.controller.request.UpdateClientRequest;
import br.com.barber.api.controller.response.ClientDetailResponse;
import br.com.barber.api.controller.response.ListClientResponse;
import br.com.barber.api.controller.response.SaveClientResponse;
import br.com.barber.api.controller.response.UpdateClientResponse;
import br.com.barber.api.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IClientMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "schedules", ignore = true)
    ClientEntity toEntity(final SaveClientRequest request);

    SaveClientResponse toSaveResponse(final ClientEntity entity);

    @Mapping(target = "schedules", ignore = true)
    ClientEntity toEntity(final long id, final UpdateClientRequest request);

    UpdateClientResponse toUpdateResponse(final ClientEntity entity);

    ClientDetailResponse toDetailResponse(final ClientEntity entity);

    List<ListClientResponse> toListResponse(final List<ClientEntity> entities);

}
