package lk.ijse.backend.service;

import jakarta.mail.MessagingException;

public interface MailService {
    void sendMail(String to, String subject, String message) throws MessagingException;
    void sendMailWithAttachment(String to, String subject, String text, byte[] attachmentData, String filename) throws MessagingException;
}
