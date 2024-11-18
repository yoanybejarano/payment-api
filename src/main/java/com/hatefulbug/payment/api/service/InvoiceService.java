package com.hatefulbug.payment.api.service;

import com.hatefulbug.payment.api.model.Invoice;
import com.hatefulbug.payment.api.request.PartialInvoice;
import com.hatefulbug.payment.api.request.PartialInvoiceUpdate;

import java.util.Date;
import java.util.List;

public interface InvoiceService {

    List<Invoice> getUserInvoices(int userId);

    List<Invoice> getInvoicesByStatus(String status);

    List<Invoice> getInvoicesByDates(Date from, Date to);

    Invoice getInvoice(int invoiceId);

    Invoice createInvoice(PartialInvoice partialInvoice);

    Invoice updateInvoice(PartialInvoiceUpdate partialInvoiceUpdate);

    Invoice updateInvoiceStatus(int invoiceId, String status);

}
