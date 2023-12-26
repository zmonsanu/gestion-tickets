package com.zms.application.commands;

import com.google.gson.Gson;
import com.zms.domain.Constant.Constantes;
import com.zms.domain.model.dto.Clients;
import com.zms.infraestructure.inputport.ClientRemotePort;
import com.zms.infraestructure.outputadapter.ClientOutPort;
import com.zms.infraestructure.outputport.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.UUID;

@Service
public class ClientUseCase implements ClientOutPort, ClientRemotePort {
    @Value("${api.url}")
    private String url;
    @Autowired
    EntityRepository entityRepository;
    @Override
    public Clients createClient(String first, String last,  String email) {
        Clients client = Clients.builder()
                        .id(UUID.randomUUID())
                        .first(first)
                        .last(last)
                        .email(email)
                        .address("")
                .build();
        return entityRepository.save(client);
    }

    @Override
    public Clients getById(UUID id) {
        return entityRepository.findById(id).orElse(new Clients());
    }

    @Override
    public List<Clients> getAll() {
        return entityRepository.findAll();
    }

    @Override
    public Clients createClientFromRemote() {
        try {
            HttpRequest request1 = HttpRequest
                    .newBuilder()
                    .uri(new URI(url))
                    .GET()
                    .build();
            HttpClient httpClient = HttpClient.newBuilder().build();

            HttpResponse<String> httpResponse = httpClient.send(request1, HttpResponse.BodyHandlers.ofString());
            if (httpResponse.statusCode() == Constantes.STATUS_OK) {
                String responseBody = httpResponse.body();
                if(responseBody!= null){
                    Clients[] apiDataArray = new Gson().fromJson(responseBody, Clients[].class);
                    Clients client = Clients.builder()
                            .id(UUID.randomUUID())
                            .first(apiDataArray[0].getFirst())
                            .last(apiDataArray[0].getLast())
                            .email(apiDataArray[0].getEmail())
                            .address(apiDataArray[0].getAddress())
                            .created(apiDataArray[0].getCreated())
                            .balance(apiDataArray[0].getBalance())
                            .build();
                    return entityRepository.save(client);
                }
            }
        } catch (URISyntaxException e) {
            System.err.println("Se ha producido una URISyntaxException: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Se ha producido una IOException: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Se ha producido una InterruptedException: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Se ha producido una Exception: " + e.getMessage());
        }
        return null;
    }
}
