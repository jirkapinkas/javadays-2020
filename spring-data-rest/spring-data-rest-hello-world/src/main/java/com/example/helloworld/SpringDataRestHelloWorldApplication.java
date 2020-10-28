package com.example.helloworld;

import com.example.helloworld.entity.priklad1.Dog;
import com.example.helloworld.entity.priklad1.Person;
import com.example.helloworld.entity.priklad2.Brand;
import com.example.helloworld.entity.priklad2.Employee;
import com.example.helloworld.entity.priklad2.Phone;
import com.example.helloworld.repository.priklad1.DogRepository;
import com.example.helloworld.repository.priklad1.PersonRepository;
import com.example.helloworld.repository.priklad2.BrandRepository;
import com.example.helloworld.repository.priklad2.EmployeeRepository;
import com.example.helloworld.repository.priklad2.PhoneRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class SpringDataRestHelloWorldApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringDataRestHelloWorldApplication.class);

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private DogRepository dogRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    @Transactional
    @EventListener(ApplicationReadyEvent.class)
    public void initDb() {
        Person person = new Person();
        person.setName("Jirka");
        personRepository.save(person);

        Dog dog1 = new Dog();
        dog1.setName("Hafík");
        dog1.setOwner(person);
        dogRepository.save(dog1);

        Dog dog2 = new Dog();
        dog2.setName("Ňafík");
        dog2.setOwner(person);
        dogRepository.save(dog2);

        List<String> dogNames = Arrays.asList(
                "Cora", "Car", "Gaston", "Brut", "Jerry", "Aron",
                "Asta", "César", "Madame", "Trixy", "Scott", "Bobík",
                "Argo", "Black", "Nero", "Harry", "Šaryk", "Lup",
                "Fred", "Lord", "Akim", "Baron", "Falco", "Amina",
                "Ron", "Žeryk", "Nelly", "Cindy", "Goldie", "Flíček",
                "Bred", "Peggy", "Žofka", "Denny", "Krista", "Honey",
                "Bella", "Jack", "Teddy", "Rita", "Goro", "Sally",
                "Bobeš", "Brit", "Jantar", "Princ", "Puňťa", "Lex",
                "Rex", "Ťapka", "Aida", "Kazan", "Dášenka", "Morgan",
                "Bret", "Betoven", "Alík", "Asta", "Čenda", "Artuš",
                "Tristan", "Nero", "Pajda", "Corina", "Blesk", "Sisi",
                "Rek", "Bond", "Sam", "Egon", "Rambo", "Fifinka",
                "Tramp", "Kazan", "César", "Pišta", "Athos", "Ruby",
                "Brita", "Jenny", "Bojar", "Pluto", "Jasper", "Haryk",
                "Brok", "Šmudla", "Sally", "Fík", "Ebony", "Bublina",
                "Dante", "Lilly", "Bessy", "Betty", "Frisco", "Hubert",
                "Bertík", "Azor", "Chlup", "Bonnie", "Robin", "Eliot",
                "Žolík", "Dixi", "Brigita", "Jeff", "Fous", "Torro",
                "Rex", "Dasty", "Ben", "Peggy", "Aramis", "Sigi",
                "Zorro", "Max", "Oskar", "Tyrl", "Columbo", "Ryška",
                "Brian", "Atom", "Nelly", "Sultán", "Kojak", "Pongo",
                "Lesan", "Kikina", "Lajka", "Arno", "Puppy", "Bron",
                "Sir", "Pussy", "Celeste", "Čert", "Snoopy", "Caruso",
                "Brix", "Pajda", "Barnabáš", "Lady", "Dasty", "Lassie",
                "Bessy", "Brix", "Baryk", "Vanilka", "Bony", "Ferda",
                "Amor", "Kalif", "Jessie", "Hasan", "Xena", "Felína",
                "Ketty", "Flek", "Dino", "Andy", "Alf", "Sting",
                "Brok", "Jackie", "Dar", "Dixi", "Arny",
                "Hektor", "Dolly", "Charlie", "Jim", "Mína", "Lima",
                "Jenny", "Bob", "Hugo", "Týna", "Bohouš",
                "Sultán", "Radar", "Teddy",
                "Mates", "Oskar", "Blesk", "Ali", "Floyd", "Žak",
                "Sany", "Tony", "Pluto", "King", "Janek", "Pearce",
                "Charlota", "Lesan", "Bandy", "Morgan", "Bern", "Corado",
                "Baf", "Bard", "Ruby", "Spartak", "Carmen", "Toby",
                "Cintie", "Yorga", "Jolly", "Mignon", "Sigi", "Kvítko",
                "Hakim", "Čikina", "Brek", "Tina", "Brest", "Danny",
                "Fogy", "Arleta", "Margo", "Hero", "Fido", "Greg",
                "Johny", "Loran", "Sabar", "Omar", "Gero",
                "Kulíšek", "Pupíček", "Mefista", "Pudl", "Donovan", "Hvězda",
                "Aranka", "Damián", "Puntík", "Astor", "Gert", "Fanfán",
                "Azor", "Punťa", "Hanny", "Viki", "York", "Rufus",
                "Boy", "Sheila", "Bella", "Tess", "Šejk", "Grand",
                "Paddy", "Ria", "Alisa", "Vigo", "Satin", "Filipes",
                "Bon", "Lasky", "Škubánek", "Picollo", "Muf", "Lucky",
                "Kim", "Frída", "Cherry", "Isar", "Wolf", "Porthos",
                "Kulička", "Faraon", "Figaro", "Bibi", "Angel", "Brunclík",
                "Ťulda", "Latté", "Štaflík", "Faust", "Molly", "Kenny",
                "Guliver", "Osman", "Špagetka", "Dingo", "Asan", "Paris",
                "Agáta", "Luccy", "Pirát", "Indy", "Špagátek", "Smaragd",
                "Bax", "Polly", "Willy", "Paco", "Yoko", "Blank",
                "Lajka", "Merlin", "Lump", "Karamel", "Senta", "Smokey",
                "Dipsy", "Azar", "Monty", "Bady", "Nessie", "Perla",
                "Gofrey", "Bruno", "Marylin", "Bina", "Woody", "Wels",
                "Fatima", "Amanda", "Bejby", "Belinda", "Mia", "Connie",
                "Mikuláš", "Wanda", "Briketa", "Daryk", "Zorba", "Keks",
                "Čiko", "Bodie", "Bazir", "Bobina", "Sorbon", "Tulák",
                "Lira", "Steffi", "Fido", "Korzár", "Bucefal", "Cash",
                "Norik", "Mona", "Clea", "Falco", "Tracy", "Batulka",
                "Viky", "Largo", "Diana", "Aladin", "Sandra", "Jasper",
                "Bary", "Debbie", "Kuba", "Hrom", "Chan", "Čaky",
                "Miky", "Bax", "Amanda", "Briny");

        int[] weights = {5, 10, 15, 18, 20, 25, 28, 30, 40, 45};

        for (String dogName : dogNames) {
            Dog dog = new Dog();
            dog.setName(dogName);
            dog.setWeight(weights[new Random().nextInt(10)]);
            dogRepository.save(dog);
        }

        /*
         * PRIKLAD 2
         */

        Brand brandIphone = new Brand();
        brandIphone.setName("iPhone");
        brandIphone = brandRepository.save(brandIphone);

        Brand brandAndroid = new Brand();
        brandAndroid.setName("iPhone");
        brandAndroid = brandRepository.save(brandAndroid);

        {
            Employee employee = new Employee();
            employee.setName("Jirka");
            employee = employeeRepository.save(employee);

            Phone phone = new Phone();
            phone.setBrand(brandIphone);
            phone.setBrandName("iPhone");
            phoneRepository.save(phone);

            employee.setPhone(phone);
        }
        {
            Employee employee = new Employee();
            employee.setName("Michal");
            employee = employeeRepository.save(employee);

            Phone phone = new Phone();
            phone.setBrand(brandAndroid);
            phone.setBrandName("Android");
            phoneRepository.save(phone);

            employee.setPhone(phone);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataRestHelloWorldApplication.class, args);
    }

}
