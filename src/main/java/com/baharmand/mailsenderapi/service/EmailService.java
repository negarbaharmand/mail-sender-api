package com.baharmand.mailsenderapi.service;

import com.baharmand.mailsenderapi.domain.dto.EmailDTO;

public interface EmailService {

   void sendEmail(EmailDTO emailDTO);
}
