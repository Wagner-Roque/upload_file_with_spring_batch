package br.com.wagner.processador_arquivo_cnab.service;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class CnabService {
    private final Path fileStrorageLocation;
    private final  JobLauncher jobLauncher;
    private final Job job;

    public CnabService(@Value("${file.upload-dir}") String fileUploadDir,
                      @Qualifier("jobLauncherAsync") JobLauncher jobLauncher,
                       Job job) {
        this.fileStrorageLocation = Paths.get(fileUploadDir);
        this.jobLauncher = jobLauncher;//asinc excution
        this.job = job;
    }

    public void uploadCnabFile(MultipartFile file) throws Exception {
        var fileName = StringUtils.cleanPath(file.getOriginalFilename());
        var targeLocation = fileStrorageLocation.resolve(fileName);
        file.transferTo(targeLocation);

        var jobParameters = new JobParametersBuilder()
                .addJobParameter("cnab", file.getOriginalFilename(),
                        String.class, true)
                .addJobParameter("cnabFile","file:"+ targeLocation.toString(), String.class)
                                .toJobParameters();

        jobLauncher.run(job, jobParameters);
    }
}
