package com.homesphere.service;

import com.homesphere.model.Report;
import java.util.List;

public interface ReportService {

    Report createReport(Report report);

    List<Report> getAllReports();

    void resolveReport(Long id);
}