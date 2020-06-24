package com.tvu.Metadata_BE.stub;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tvu.Metadata_BE.Constants;
import com.tvu.Metadata_BE.Model.Records;
import com.tvu.Metadata_BE.Model.Scene;
import com.tvu.Metadata_BE.Model.Session;
import com.tvu.Metadata_BE.Model.ShortStories;
import com.tvu.Metadata_BE.Model.Sources;
import com.tvu.Metadata_BE.dto.MetaDataResponse;
import com.tvu.Metadata_BE.dto.MetaRequestsDTO;
import com.tvu.Metadata_BE.dto.RecordsDTO;
import com.tvu.Metadata_BE.dto.SceneDTO;
import com.tvu.Metadata_BE.dto.ShortStoriesDTO;
import com.tvu.Metadata_BE.dto.SourcesDTO;
import com.tvu.Metadata_BE.repository.RecordRepository;
import com.tvu.Metadata_BE.repository.SceneRepository;
import com.tvu.Metadata_BE.repository.SessionRepository;
import com.tvu.Metadata_BE.repository.ShortStoriesRepository;
import com.tvu.Metadata_BE.repository.SourceRepository;


@Service
public class MetadataStub {
	public String delims=",";
	@Autowired
	private SessionRepository sessionrepo;
	@Autowired
	private RecordRepository recordrepo;
	@Autowired
	private SourceRepository sourcerepo;
	@Autowired
	private SceneRepository scenerepo;
	@Autowired
	private ShortStoriesRepository storyrepo;

	@Transactional
	public MetaDataResponse saveData(MetaRequestsDTO context)
	{
		MetaDataResponse response=new MetaDataResponse();
		Session sessionDTO=new Session();
		sessionDTO.setId(context.getId());
		sessionDTO.setTitle(context.getTitle());
		sessionDTO.setProducedBy(context.getProducedBy());
		sessionDTO.setStatus(context.getStatus());
		sessionDTO.setPlaceRootPath(context.getPlaceRootPath());
		sessionDTO.setStartTime(context.getStartTime());
		sessionDTO.setEndTime(context.getEndTime());
		sessionDTO.setDescription(context.getDescription());
		sessionrepo.save(sessionDTO);
		List<SourcesDTO> sources=context.getSources();
		if(!sources.isEmpty()){
			for(SourcesDTO source:sources)
			{
				List<RecordsDTO> records=source.getRecords();
				if(!records.isEmpty()){
					for(RecordsDTO record:records)
					{
						Records rec=new Records();
						rec.setId(record.getID());
						rec.setSession(sessionDTO);
						rec.setSourceId(source.getID());
						List<String> tags=record.getTags();
						rec.setTags(String.join(delims, tags));
						rec.setTitle(record.getTitle());
						rec.setStartTimeStamp(record.getStartTimeStamp());
						rec.setEndTimeStamp(record.getEndTimeStamp());
						recordrepo.save(rec);
					}
				}
				Sources sourceData=new Sources();
				sourceData.setId(source.getID());
				sourceData.setName(source.getName());
				sourceData.setSession(sessionDTO);
				sourceData.setStatus(source.getStatus());
				sourceData.setStartTime(source.getStartTimeStamp());
				sourceData.setStopTime(source.getEndTimeStamp());
				sourcerepo.save(sourceData);		
			}
		}
		List<ShortStoriesDTO> shortStories=context.getShortStories();
		if(!shortStories.isEmpty()){
			for(ShortStoriesDTO story:shortStories)
			{
				ShortStories stories=new ShortStories();
				stories.setId(story.getID());
				stories.setAurthor(story.getAurthor());
				stories.setSession(sessionDTO);
				stories.setFrontCover(story.getFrontCover());
				List<String> tags=story.getTags();
				stories.setTag(String.join(delims, tags));
				stories.setTitle(story.getTitle());
				//stories.setSourceid(sourceData);;
				stories.setCreatedAt(story.getCreatedAt());
				storyrepo.save(stories);
				List<SceneDTO> scenes=story.getScenes();
				if(!scenes.isEmpty()){
					for(SceneDTO scene:scenes)
					{
						Scene sceneData=new Scene();
						sceneData.setSourceid(scene.getAssociatedSource());
						sceneData.setShortStory(stories);
						sceneData.setStartTimeStamp(scene.getStartTimeStamp());
						sceneData.setStopTimeStamp(scene.getEndTimeStamp());
						scenerepo.save(sceneData);
					}
				}
			}
		}
		response.setErrorCode(Constants.API.SUCCESS_CODE);
		response.setErrorMessage(Constants.API.SUCCESS_MESSAGE);
		return response;

	}
}
