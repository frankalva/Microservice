package com.urprovider.users;

import com.urprovider.users.store.domain.model.entity.Store;
import com.urprovider.users.store.domain.persistence.StoreRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

class UsersApplicationTests {

    @Mock
    private StoreRepository storeRepository;
    @Test
    public void createStore() {
        Store store = Store.builder()
                .storeName("Tambo")
                .email("tambo@gmail.com")
                .address("Av Lima 3910")
                .image("https://peruretail.sfo3.cdn.digitaloceanspaces.com/wp-content/uploads/Tambo-6-2.png")
                .phone(938281233)
                .lastName("Tambo")
                .password("123")
                .name("Tambo")
                .build();
        storeRepository.save(store);
    }

}
