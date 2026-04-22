package com.homesphere.service;

import com.homesphere.model.Report;
import com.homesphere.repository.ReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public Report createReport(Report report) {
        return reportRepository.save(report);
    }

    @Override
    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    @Override
    public void resolveReport(Long id) {
        Report report = reportRepository.findById(id).orElseThrow();
        report.setStatus("RESOLVED");
        reportRepository.save(report);
    }
}