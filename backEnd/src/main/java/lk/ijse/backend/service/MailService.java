package lk.ijse.backend.service;

import jakarta.mail.MessagingException;

public interface MailService {
    void sendMail(String to, String subject, String message) throws MessagingException;
}
