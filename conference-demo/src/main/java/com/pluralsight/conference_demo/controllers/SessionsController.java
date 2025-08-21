package com.pluralsight.conference_demo.controllers;

import com.pluralsight.conference_demo.models.Session;
import com.pluralsight.conference_demo.repositories.SessionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController
{
    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public List<Session> list()
    {
        return sessionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Session get(@PathVariable Long id)
    {
        return sessionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Session not found"));
    }

    @PostMapping
    public Session create(@RequestBody final Session session)
    {
        return sessionRepository.saveAndFlush(session);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id)
    {
        sessionRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Session Update(@PathVariable Long id, @RequestBody Session session)
    {
        Session existingSession = sessionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Session not found"));
        BeanUtils.copyProperties(session, existingSession, "session_id");

        return sessionRepository.saveAndFlush(existingSession);
    }
}