package pl.devfoundry.testing.account;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import pl.devfoundry.testing.account.Account;
import pl.devfoundry.testing.account.Address;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;


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

    @RepeatedTest(25)
    @Test
    void newAccountWithNotNullAddressShouldBeActive() {

        //given
        Address address = new Address("Puławska", "46/6");

        //when
        Account account = new Account(address);

        //then
        assumingThat(address!=null, () -> {
            assertTrue(account.isActive());
        });
    }

    @Test
    void invalidEmailShouldThrowException() {

        //given
        Account account = new Account();

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> account.setEmail("wrongEmail"));
    }

    @Test
    void validEmailShouldBeSet() {
        //given
        Account account = new Account();

        //when
        account.setEmail("kontakt@devfoundry.pl");

        //then
        assertThat(account.getEmail(), is("kontakt@devfoundry.pl"));
    }

}
