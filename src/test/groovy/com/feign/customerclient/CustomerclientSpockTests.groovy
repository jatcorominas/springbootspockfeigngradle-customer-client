package com.feign.customerclient

import com.feign.customerclient.model.Customer
import com.feign.customerclient.service.CustomerServiceClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.core.env.Environment
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import spock.lang.Specification

@SpringBootTest
class CustomerclientSpockTests extends Specification {
    @Autowired
    Environment environment;

    def "application should start up properly"(){
        expect:
        environment != null
    }

    def "unit test of the CustomerServiceClient interface should return a list of Customers"(){
        given:
        List<Customer> expectedCustomerList = new ArrayList<Customer>() {{ add(new Customer(10, "customer-10", 57)); add(new Customer( 11, "customer-11", 48)); add(new Customer( 12, "customer-12", 70)) }}
        CustomerServiceClient mockCustomerServiceClient = Mock { getAllCustomers() >> new ArrayList<Customer>() {{ add(new Customer(10, "customer-10", 57)); add(new Customer( 11, "customer-11", 48)); add(new Customer( 12, "customer-12", 70)) }} }

        when:
        List<Customer> actualCustomerList = mockCustomerServiceClient.getAllCustomers()

        then:
        actualCustomerList != null;
        actualCustomerList.size() == expectedCustomerList.size()
        expectedCustomerList.get(0).getId()==actualCustomerList.get(0).getId()
        expectedCustomerList.get(0).getAge()==actualCustomerList.get(0).getAge()
        expectedCustomerList.get(0).getName()==actualCustomerList.get(0).getName()
        expectedCustomerList.get(1).getId()==actualCustomerList.get(1).getId()
        expectedCustomerList.get(1).getAge()==actualCustomerList.get(1).getAge()
        expectedCustomerList.get(1).getName()==actualCustomerList.get(1).getName()
        expectedCustomerList.get(2).getId()==actualCustomerList.get(2).getId()
        expectedCustomerList.get(2).getAge()==actualCustomerList.get(2).getAge()
        expectedCustomerList.get(2).getName()==actualCustomerList.get(2).getName()
    }

    def "unit test of the CustomerServiceClient interface should return a Customer with id=4"(){
        given:
        Customer expectedCustomer = new Customer(4,"customer-4", 39);
        CustomerServiceClient mockCustomerServiceClient = Mock { getCustomer(4) >> new Customer(4, "customer-4", 39) }

        when:
        Customer actualCustomer = mockCustomerServiceClient.getCustomer(4);

        then:
        actualCustomer != null
        expectedCustomer.getAge()==actualCustomer.getAge()
        expectedCustomer.getName()==actualCustomer.getName()
        expectedCustomer.getId()==actualCustomer.getId()
    }

    def "unit test of the application should return a list of Customers and an HttpStatus of OK"(){
        given:
        List<Customer> expectedCustomerList = new ArrayList<Customer>() {{ add(new Customer(10, "customer-10", 57)); add(new Customer( 11, "customer-11", 48)); add(new Customer( 12, "customer-12", 70)) }}
        TestRestTemplate mockTestRestTemplate = Mock{ getForEntity( _, List<Customer>.class ) >> new ResponseEntity(new ArrayList<Customer>(){{add(new Customer(10,"customer-10", 57)); add(new Customer(11,"customer-11", 48)); add(new Customer(12, "customer-12", 70))}}, HttpStatus.OK )}

        when:
        ResponseEntity<List<Customer>> entity = mockTestRestTemplate.getForEntity("http://localhost:8091/fetchCustomers", List<Customer>.class)

        then:
        entity != null;
        entity.statusCode == HttpStatus.OK
        entity.hasBody()
        entity.getBody().size() == expectedCustomerList.size()
        List<Customer> actualCustomerList = entity.getBody()
        Customer expectedCustomer=null
        Customer actualCustomer=null
        for(int i = 0 ; i < expectedCustomerList.size(); i++){
            expectedCustomer = expectedCustomerList.get(i)
            actualCustomer = actualCustomerList.get(i)
            expectedCustomer.getAge()==actualCustomer.getAge()
            expectedCustomer.getName().equals(actualCustomer.getName())
            expectedCustomer.getId()==actualCustomer.getId()

        }


    }

    def "unit test of the application should return a Customer with id=3 and an HttpStatus of OK"(){
        given:
        TestRestTemplate mockTestRestTemplate = Mock{ getForEntity( _, Customer.class) >> new ResponseEntity( new Customer(3, "customer-3", 50), HttpStatus.OK) }

        when:
        ResponseEntity<Customer> entity = mockTestRestTemplate.getForEntity("http://locahost:8091/fetchCustomer/3", Customer.class)

        then:
        entity != null;
        entity.statusCode == HttpStatus.OK
        entity.hasBody() == true
        entity.body.getId() == 3
        entity.body.getName() == "customer-3"
        entity.body.getAge() == 50

    }

    def "unit test of the application should an null body and an HttpStatus of NOT_FOUND"(){
        given:
        TestRestTemplate mockTestRestTempate = Mock { getForEntity(_, Customer.class) >> new ResponseEntity( null, HttpStatus.NOT_FOUND)}

        when:
        ResponseEntity<Customer> entity = mockTestRestTempate.getForEntity( "http://localhost:8091/fetchCustomer/xxx", Customer.class)

        then:
        entity != null
        entity.statusCode == HttpStatus.NOT_FOUND
        entity.hasBody() == false
        entity.body == null
    }

    def "unit test of the application should return a null list of Customers and an HttpStatus of NOT_FOUND"(){
        given:
        TestRestTemplate mockTestRestTemplate = Mock { getForEntity(_, List<Customer>.class) >> new ResponseEntity( null, HttpStatus.NOT_FOUND)}

        when:
        ResponseEntity<List<Customer>> entity = mockTestRestTemplate.getForEntity("http://localhost:8091/fetchCustomers", List<Customer>.class)

        then:
        entity != null
        entity.statusCode == HttpStatus.NOT_FOUND
        entity.hasBody() == false
        entity.body == null
    }

    def "unit test of the application should return a null body and an HttpStatus of INTERNAL_SERVER_ERROR"(){
        given:
        TestRestTemplate mockTestRestTempate = Mock { getForEntity(_, Customer.class) >> new ResponseEntity( null, HttpStatus.INTERNAL_SERVER_ERROR)}

        when:
        ResponseEntity<Customer> entity = mockTestRestTempate.getForEntity( "http://localhost:8091/fetchCustomer/xxx", Customer.class)

        then:
        entity != null
        entity.statusCode == HttpStatus.INTERNAL_SERVER_ERROR
        entity.hasBody() == false
        entity.body == null
    }

    def "unit test of the application should an empty list of Customers and an HttpStatus of INTERNAL_SERVER_ERROR"(){
        given:
        TestRestTemplate mockTestRestTempate = Mock { getForEntity(_, List<Customer>.class) >> new ResponseEntity( null, HttpStatus.INTERNAL_SERVER_ERROR)}

        when:
        ResponseEntity<List<Customer>> entity = mockTestRestTempate.getForEntity( "http://localhost:8091/fetchCustomers", List<Customer>.class)

        then:
        entity != null
        entity.statusCode == HttpStatus.INTERNAL_SERVER_ERROR
        entity.hasBody() == false
        entity.body == null
    }
}
