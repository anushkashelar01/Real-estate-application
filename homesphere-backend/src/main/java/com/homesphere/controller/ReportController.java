package com.homesphere.controller;

import com.homesphere.model.Report;
import com.homesphere.service.ReportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin(origins = "*")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    // USER: REPORT PROPERTY
    @PostMapping
    public Report createReport(@RequestBody Report report) {
        return reportService.createReport(report);
    }

    // ADMIN: VIEW REPORTS
    @GetMapping
    public List<Report> getAllReports() {
        return reportService.getAllReports();
    }

    // ADMIN: RESOLVE
    @PutMapping("/{id}/resolve")
    public String resolve(@PathVariable Long id) {
        reportService.resolveReport(id);
        return "Report resolved";
    }
}