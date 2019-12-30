package edu.swjtuhc.cgService.serviceImpl;



import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.swjtuhc.cgService.mapper.NewsJpgMapper;
import edu.swjtuhc.cgService.model.Article;
import edu.swjtuhc.cgService.model.NewsJpg;
import edu.swjtuhc.cgService.model.TeacherTime;
import edu.swjtuhc.cgService.service.NewsJpgService;
import edu.swjtuhc.cgService.service.articleService;
import edu.swjtuhc.cgService.util.IdWorker;
import edu.swjtuhc.cgService.util.JwtTokenUtil;


@Service
public class NewsJpgServiceImpl implements NewsJpgService {
    private NewsJpgMapper NewsJpgMapper;
    private IdWorker idWorker;
    @Autowired
    public NewsJpgServiceImpl(
            JwtTokenUtil jwtTokenUtil,
            NewsJpgMapper NewsJpgMapper) {
        this.NewsJpgMapper = NewsJpgMapper;
        this.idWorker=new IdWorker(0, 0);
    }
	@Override
	public Long getNextId() {
		// TODO Auto-generated method stub
		return idWorker.nextId();
	}
	@Override
	public int createJpg(NewsJpg newsjpg, InputStream fileStream) {
		// TODO Auto-generated method stub
		String path = "F:\\localFiles\\";
		int i  = -1;
		byte[] bs = new byte[1024];
		int len;
		try {
			File tempFile = new File(path);
			if (!tempFile.exists()) {
				tempFile.mkdirs();
			}
			Date today = new Date();
			String fileName = today.getTime()+newsjpg.getPoster();
			newsjpg.setPoster("/posters/"+fileName);
			OutputStream os = new FileOutputStream(tempFile.getPath() + File.separator + fileName);
			while (((len = fileStream.read(bs)) != -1)) {
				os.write(bs,0,len);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			i = -2;
		}if (newsjpg.getPoster().equals("")) {
			i = -3;
		}else {
			newsjpg.setjId(getNextId());
			i = NewsJpgMapper.createJpg(newsjpg);
		}
		return i;
	}


	



    
}

