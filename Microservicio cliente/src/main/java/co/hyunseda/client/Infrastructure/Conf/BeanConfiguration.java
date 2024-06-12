package co.hyunseda.client.Infrastructure.Conf;


import co.hyunseda.client.Domain.Puerto.IClientRepository;
import co.hyunseda.client.Application.Service.ClientService;
import co.hyunseda.client.Application.Service.IClientService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public IClientService productBeanService(final IClientRepository clientRepository) {
        return new ClientService(clientRepository);
    }

}
