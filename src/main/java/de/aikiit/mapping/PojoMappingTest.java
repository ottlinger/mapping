/*
    Mapping - Copyright (C) 2018, Aiki IT

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.aikiit.mapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import org.junit.Test;

import java.io.IOException;
import java.util.Optional;

public class PojoMappingTest {
    @Test
    public void checkObjectMapper() throws IOException {
        TestPojo2 bla = new TestPojo2();
        bla.setHello("bla");

        String s = createJsonMapper().writeValueAsString(bla);
    }

    private static ObjectMapper createJsonMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Jdk8Module());
        return mapper;
    }

    public static class TestPojo2 {
        private String hello;

        public Optional<String> getHello() {
            return Optional.ofNullable(hello);
        }

        public void setHello(String hello) {
            this.hello = hello;
        }
    }

}