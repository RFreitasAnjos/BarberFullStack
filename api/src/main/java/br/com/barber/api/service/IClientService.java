package br.com.barber.api.service;

import br.com.barber.api.entity.ClientEntity;

public interface IClientService {

    ClientEntity save(final ClientEntity entity);

    ClientEntity update(final ClientEntity entity);

    void delete(final Long id);
}
