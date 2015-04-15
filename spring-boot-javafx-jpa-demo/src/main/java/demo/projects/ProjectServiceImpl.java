/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package demo.projects;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Thomas Darimont
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class ProjectServiceImpl implements ProjectService {

	private final ProjectRepository projectRepository;
	private final TaskRepository taskRepository;

	public List<Project> findAllProjects() {
		return projectRepository.findAll();
	}

	public List<Task> findAllTasksByProject(Project project) {
		return taskRepository.findByProject(project);
	}

	@Transactional
	public Task save(Task task) {
		return taskRepository.save(task);
	}

	@Transactional
	public Project save(Project project) {
		return projectRepository.save(project);
	}
}
