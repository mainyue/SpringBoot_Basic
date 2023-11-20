package com.yue.springboot_init_web.converter;

import com.yue.springboot_init_web.bean.Person;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author yue
 * @description 自定义Converter:
 *  application/-xyue:将Person属性去除以';'分隔。如 ‘yue;12'
 * @create 2023-02-28 13:06
 */
public class MyConverter implements HttpMessageConverter<Person> {
    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return false;
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {

        return clazz.isAssignableFrom(Person.class);
    }

    @Override
    //服务器要统计所有MessageConverter都能写出哪些内容类型
    //application/x-yue
    public List<MediaType> getSupportedMediaTypes() {
        //把字符串解析成MediaType集合
        return MediaType.parseMediaTypes("application/x-yue");
    }

    @Override
    public Person read(Class<? extends Person> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    //自定义协议数据写出
    @Override
    public void write(Person person, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        String data = person.getUserName()+";"+person.getAge()+";"+person.getBirth();

        //写出
        OutputStream body = outputMessage.getBody();
        body.write(data.getBytes());
    }
}
