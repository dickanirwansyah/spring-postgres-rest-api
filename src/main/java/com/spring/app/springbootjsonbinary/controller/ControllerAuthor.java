package com.spring.app.springbootjsonbinary.controller;


import com.spring.app.springbootjsonbinary.entity.Author;
import com.spring.app.springbootjsonbinary.exception.BadRequestException;
import com.spring.app.springbootjsonbinary.exception.NotFoundException;
import com.spring.app.springbootjsonbinary.request.AddNewAuthorRequest;
import com.spring.app.springbootjsonbinary.request.GetDetailsAuthorRequest;
import com.spring.app.springbootjsonbinary.request.UpdateAuthorRequest;
import com.spring.app.springbootjsonbinary.response.ErrorResponse;
import com.spring.app.springbootjsonbinary.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/author")
public class ControllerAuthor {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<Author> listAuthor(){
        List<Author> authors = authorService.listAuthor();
        if(authors.isEmpty()){
            throw new NotFoundException("sorry list author is null");
        }
        return authors;
    }

    @GetMapping(value = "/{authorId}")
    public ResponseEntity<Optional<Author>> findId(@PathVariable String authorId){
        GetDetailsAuthorRequest request = getId(authorId);

        Optional<Author> author = authorService.findById(request);
        if (!author.isPresent()){
            throw new NotFoundException("maaf kode ini tidak ada");
        }
        return new ResponseEntity<Optional<Author>>(author, HttpStatus.OK);
    }

    private GetDetailsAuthorRequest getId(String authorIds){
        return GetDetailsAuthorRequest
                .builder()
                .authorId(authorIds)
                .build();
    }

    /**
    @GetMapping("/list")
    public ResponseEntity<List<Author>> authorList() throws Exception{
        return Optional.ofNullable(authorService.listAuthor())
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.OK))
                .orElseThrow(() -> new NotFoundException("list is empty"));
    }
    **/

    @PostMapping(value = "/create")
    public ResponseEntity<Author> create(@Valid @RequestBody AddNewAuthorRequest requestAuthor){
        return Optional.ofNullable(authorService.create(requestAuthor))
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.CREATED))
                .orElse(new ResponseEntity<Author>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping(value = "/update")
    public ResponseEntity<Author> update(@Valid @RequestBody UpdateAuthorRequest request){
        return Optional.ofNullable(authorService.update(request))
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.OK))
                .orElse(new ResponseEntity<Author>(HttpStatus.BAD_REQUEST));
    }


    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlingError(MethodArgumentNotValidException exception){

        String errorMessage = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .findFirst()
                .orElse(exception.getMessage());

        return ErrorResponse.builder()
                .message(errorMessage)
                .tanggal(new Date())
                .status(false).build();

    }
}
