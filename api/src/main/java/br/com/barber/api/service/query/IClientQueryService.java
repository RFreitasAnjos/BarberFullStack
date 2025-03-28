package br.com.barber.api.service.query;

import java.util.List;

import br.com.barber.api.entity.ClientEntity;

public interface IClientQueryService {
    ClientEntity findById(final Long id);

    List<ClientEntity> list();

    void verifyPhone(final String phone);

    void verifyPhone(final Long id, final String phone);

    void verifyEmail(final String email);

    void verifyEmail(final Long id, final String email);

}
