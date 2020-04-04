package com.id.nana.boot.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import com.id.nana.boot.entity.Nasabah;

@Component
public interface NasabahDao extends PagingAndSortingRepository<Nasabah, String> {

}
