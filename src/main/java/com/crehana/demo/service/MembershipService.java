package com.crehana.demo.service;

import com.crehana.demo.model.Membership;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MembershipService {
    List<Membership> getAllMemberships();
    Page<Membership> getAllMembershipsPage(Pageable pageable);
}
