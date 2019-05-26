package pl.dominisz.springintroduction.converter;

/**
 * http://dominisz.pl
 * 26.05.2019
 */
public interface Converter<TM, TE> {

    TM toModel(TE entity);
    TE toEntity(TM model);

}
