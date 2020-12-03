package com.crehana.demo.service.impl;

import com.crehana.demo.model.Membership;
import com.crehana.demo.repository.MembershipRepository;
import com.crehana.demo.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembershipServiceImpl implements MembershipService {

    @Autowired
    private MembershipRepository membershipRepository;

    @Override
    public List<Membership> getAllMemberships() { return this.membershipRepository.findAll(); }

    @Override
    public Page<Membership> getAllMembershipsPage(Pageable pageable) { return this.membershipRepository.findAll(pageable); }
}
