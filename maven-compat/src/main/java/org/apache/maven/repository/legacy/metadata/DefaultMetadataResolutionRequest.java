package org.apache.maven.repository.legacy.metadata;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.util.ArrayList;
import java.util.List;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.artifact.repository.RepositoryCache;
import org.apache.maven.artifact.repository.RepositoryRequest;

/**
 * Forms a request to retrieve artifact metadata.
 * 
 * @author Benjamin Bentmann
 */
public class DefaultMetadataResolutionRequest
    implements MetadataResolutionRequest
{

    private Artifact artifact;

    private ArtifactRepository localRepository;

    private List<ArtifactRepository> remoteRepositories;

    private RepositoryCache cache;

    private boolean resolveManagedVersions;

    private boolean offline;

    public DefaultMetadataResolutionRequest()
    {
        // does nothing
    }

    public DefaultMetadataResolutionRequest( RepositoryRequest request )
    {
        setLocalRepository( request.getLocalRepository() );
        setRemoteRepositories( request.getRemoteRepositories() );
        setCache( request.getCache() );
        setOffline( request.isOffline() );
    }

    public Artifact getArtifact()
    {
        return artifact;
    }

    public DefaultMetadataResolutionRequest setArtifact( Artifact artifact )
    {
        this.artifact = artifact;

        return this;
    }

    public ArtifactRepository getLocalRepository()
    {
        return localRepository;
    }

    public DefaultMetadataResolutionRequest setLocalRepository( ArtifactRepository localRepository )
    {
        this.localRepository = localRepository;

        return this;
    }

    public List<ArtifactRepository> getRemoteRepositories()
    {
        if ( remoteRepositories == null )
        {
            remoteRepositories = new ArrayList<ArtifactRepository>();
        }

        return remoteRepositories;
    }

    public DefaultMetadataResolutionRequest setRemoteRepositories( List<ArtifactRepository> remoteRepositories )
    {
        this.remoteRepositories = remoteRepositories;

        return this;
    }

    public boolean isResolveManagedVersions()
    {
        return resolveManagedVersions;
    }

    public DefaultMetadataResolutionRequest setResolveManagedVersions( boolean resolveManagedVersions )
    {
        this.resolveManagedVersions = resolveManagedVersions;

        return this;
    }

    public RepositoryCache getCache()
    {
        return cache;
    }

    public DefaultMetadataResolutionRequest setCache( RepositoryCache cache )
    {
        this.cache = cache;

        return this;
    }

    public boolean isOffline()
    {
        return offline;
    }

    public DefaultMetadataResolutionRequest setOffline( boolean offline )
    {
        this.offline = offline;

        return this;
    }

}