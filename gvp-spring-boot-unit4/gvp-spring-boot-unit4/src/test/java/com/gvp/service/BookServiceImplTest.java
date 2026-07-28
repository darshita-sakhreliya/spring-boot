// package com.gvp.service;

// import static org.assertj.core.api.Assertions.assertThat;
// import static org.assertj.core.api.Assertions.assertThatThrownBy;
// import static org.mockito.Mockito.when;

// import com.gvp.unit4.dto.BookRequest;
// import com.gvp.unit4.exception.ResourceNotFoundException;
// import com.gvp.unit4.model.Category;
// import com.gvp.unit4.repository.BookRepository;
// import com.gvp.unit4.repository.CategoryRepository;
// import java.math.BigDecimal;
// import java.util.Optional;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.junit.jupiter.MockitoExtension;

// @ExtendWith(MockitoExtension.class)
// class BookServiceImplTest {

//     @Mock private BookRepository bookRepository;
//     @Mock private CategoryRepository categoryRepository;
//     @InjectMocks private BookServiceImpl bookService;

//     @Test
//     void create_savesBookWhenCategoryExists() {
//         when(categoryRepository.existsById(1L)).thenReturn(true);
//         when(categoryRepository.findById(1L)).thenReturn(Optional.of(new Category(1L, "Programming", "desc")));

//         BookRequest request = new BookRequest();
//         request.setTitle("Effective Java");
//         request.setAuthor("Joshua Bloch");
//         request.setCategoryId(1L);
//         request.setPrice(new BigDecimal("45.99"));
//         request.setStock(10);

//         when(bookRepository.save(org.mockito.ArgumentMatchers.any()))
//                 .thenAnswer(inv -> { var b = inv.getArgument(0, com.gvp.unit4.model.Book.class); b.setId(1L); return b; });

//         var result = bookService.create(request);

//         assertThat(result.getTitle()).isEqualTo("Effective Java");
//         assertThat(result.getCategoryName()).isEqualTo("Programming");
//     }

//     @Test
//     void create_throwsWhenCategoryMissing() {
//         when(categoryRepository.existsById(99L)).thenReturn(false);
//         BookRequest request = new BookRequest();
//         request.setCategoryId(99L);

//         assertThatThrownBy(() -> bookService.create(request))
//                 .isInstanceOf(ResourceNotFoundException.class)
//                 .hasMessageContaining("Category not found");
//     }
// }