/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jdbi.v3.sqlobject.subpackage;

import org.jdbi.v3.Something;
import org.jdbi.v3.sqlobject.Bind;
import org.jdbi.v3.sqlobject.SomethingMapper;
import org.jdbi.v3.sqlobject.SqlQuery;
import org.jdbi.v3.sqlobject.SqlUpdate;
import org.jdbi.v3.sqlobject.customizers.RegisterMapper;

@RegisterMapper(SomethingMapper.class)
public abstract class SomethingDao
{
    @SqlUpdate("insert into something (id, name) values (:id, :name)")
    public abstract void insert(@Bind("id") int id, @Bind("name") String name);

    @SqlQuery("select id, name from something where id = :id")
    public abstract Something findById(@Bind("id") int id);

    public Something findByIdHeeHee(int id) {
        return findById(id);
    }

    public abstract void totallyBroken();

}
