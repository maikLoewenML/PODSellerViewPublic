package com.example.podsellerview3.mba;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MBARepository extends CrudRepository<MBA, UUID> {

}
