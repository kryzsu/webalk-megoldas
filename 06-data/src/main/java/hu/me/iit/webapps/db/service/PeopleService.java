package hu.me.iit.webapps.db.service;

public interface PeopleService {
	Iterable<People> getAllPeople();

	People create(People toPeople);

    void delete(Long id);

	People getById(Long id);

	void save(People people);

	Iterable<? extends People> findByAgeGreatherThan(int age);
}
