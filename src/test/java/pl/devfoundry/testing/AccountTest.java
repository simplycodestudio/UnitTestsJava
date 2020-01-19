package pl.devfoundry.testing;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;


class AccountTest {


    @Test
    void newAccountShouldNotBeActive() {
        //given
        Account newAccount = new Account();
        //then
        assertFalse(newAccount.isActive(), "Check if new account is not active");
        //hamcrest
        assertThat(newAccount.isActive(), equalTo(false));
        assertThat(newAccount.isActive(), is(false));
        //assertJ

    }

    @Test
    void accountShouldBeActiveAfterActivation() {
        //given
        Account newAccount = new Account();

        //when
        newAccount.activate();

        //then
        assertTrue(newAccount.isActive());
        //hamcrest
        assertThat(newAccount.isActive(), equalTo(true));
        //assertj

    }

    @Test
    void newlyCreatedAccountShouldNotHaveDefaultVeliveryAddressSet() {
        //given
        Account account = new Account();

        //when
        Address address = account.getDefaultDeliveryAdress();

        //then
        assertNull(address);
        //hamcrest
        assertThat(address, nullValue());
        //assertj

    }

    @Test
    void defaultDeliveryAdressShouldNotBeNullAfterBeingSet() {
        //given
        Address address = new Address("Krakowska", "65d");
        Account account = new Account();
        account.setDefaultDeliveryAdress(address);

        //when
        Address defaultAdress = account.getDefaultDeliveryAdress();

        //then
        assertNotNull(defaultAdress);
        //hamcrest
        assertThat(defaultAdress, notNullValue());
        //assertj


    }



}
